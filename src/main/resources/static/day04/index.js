console.log("index.js open");

// [4] 개별 삭제 함수
const onDelete = async (sno) => {
    // (1) 삭제할 번호 : sno
    // (2) axios 통신
    const response = await axios.delete(`/day04/student?sno=${sno}`)
    if(response.data == 1){ onFindAll();} //만약에 응답내용이 1이면 삭제 수정 -> 전체 조회함수 실행


}




// [3] 개별 수정 함수
const onUpdate = async (sno) => {

        //(1) 수장할 값 받기
        const name = prompt('새로운이름')
        const kor = prompt('새로운 국어점수')
        const math = prompt('새로운 수학점수')
        //(2) 객체화
        const obj = {sno ,name, kor, math  };
        //(3) axios 통신
        const response = await axios.put('/day04/student' , obj)
        if( response.data == 1){ onFindAll()} // 만약에 응답 자료 내용이 1이면 수정 성공 -> 전체조회 함수 실행

}






//[2] 전체 조회 함수
const onFindAll = async () => {
    //(동기화) await , async
    try{
    const response = await axios.get('/day04/student')
    console.log(response.data); // response 응답(정보)객체 , response.data : 응답객체내 본문내용

    const tbody = document.querySelector('tbody');
    let html = ''
            response.data.forEach( student => {
                html += `
                    <tr>
                        <th>${student.name}</th>
                        <th>${student.kor}</th>
                        <th>${student.math}</th>
                        <td>
                            <button onclick="onUpdate(${student.sno})">수정</button>
                            <button onclick="onDelete(${student.sno})">삭제</button>

                        </td>
                    </tr>`
            })

    tbody.innerHTML = html;

  }catch(e) {console.log(e);}
}//f end
onFindAll(); // 전체조회 함수 실행






//[1] 등록함수
const onSave = async () => {
    //(1)
    const name = document.querySelector('.name').value;
    const kor = document.querySelector('.kor').value;
    const math = document.querySelector('.math').value;
    //(*) 객체{} 선언할때 대입할 매개변수명이 객체의 필드명과 동일하면 생략가능
    //const obj = {name :name , kor : kor , math : math };
    const obj = {name, kor , math};
    console.log(obj);


    //(*) fetch 대신에 axios 활용한 비동기통신 vs 동기화통신 , 상황에 따라 다르다.
    //(비동기)
    axios.post('/day04/student' , obj)
        .then(response => {console.log(response); onFindAll();})
        .catch(e => {console.log(e)})





    // (*) fetch(JS내장함수) vs Axios(기본값JSON) vs $.ajax(JQuery)
    // (1) fetch 와 비슷한 구조의 axios 사용하는 방법
    /*axios.post('/day04/student' , obj)
                .then(response => {console.log(response);})
                .catch(e => {console.log(e)})
        //1. axios 설치 : HTML에 AXIOS CDN 코드를 넣어준다.
        //2. axios 문법
            // axios.[HTTP메소드명].()  : axios.get(), axios.post(), axios.put(), axios.delete()
            //2. .('통신할HTTP주소' , {옵션})*/


    // (2)
    /*console.log('axios 실행'); //1. 첫번째 콘솔
    axios.post('/day04/student' , obj)
                    .then(response => {console.log(response);}) //2. 두번째 콘솔
                    .catch(e => {console.log(e)})

    console.log('axios 실행 후')// 3. 세번째 콘솔*/

    // 첫번째 콘솔 --> 세번째 콘솔 --> 두번째 콘솔 : 순서가 달라지는 이유
    //비동기 통신(JS는 axios요청을 보낸후에 응답을 기다리지 않고 다음 코드를 실행)
    //(비동기) : 먼저 처리/응답 된 순서대로 처리한다. '커피' 먼저 나온다.
    //(동기) : 앞에 있는 처리가 응답/처리가 올때까지 다음 요청은 대기 상태로

    //(3)
    //console.log('axios 실행'); //1. 첫번째 콘솔
    //const response = axios.post('/day04/student' , obj)
    //console.log(response.data); //2. 두번째 콘솔
    //console.log('axios 실행 후')//3. 세번째 콘솔
    // 실행순서 : 첫번째 콘솔 -> 두번째 콘솔 =? 세번째 콘솔 : 왜? axios의 응답값이 반환되기전에 두번째 콘솔이 출력된다.

    //(4) 동기화 방법 = 필요에 따라 / 형식 vs 비동기 방법 = 기본값
        // 동기화 방법 : 1.await 함수명() 2.현재 함수명 앞에 async
    //const response = await axios.post('/day04/student', obj)
    //console.log(response.data); //2. 두번째 콘솔
    //console.log('axios 실행 후')//3. 세번째 콘솔



    // 원래 쓰던 방법
    /*
    option = {
        method: 'POST',
        headers: { 'content-Type': 'application/json' },
        body : JSON.stringify(obj),
    }
    fetch('/day04/student', option)
        .then(response => response.json())
        .then(data => {console.log(data);})
        .catch(error => {console.log('Error:', error);})
    */
}