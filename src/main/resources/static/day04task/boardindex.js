
//[1] 등록함수
const onSave = async () => {
    //(1)
    const name = document.querySelector('.title').value;
    const math = document.querySelector('.content').value;
    //(*) 객체{} 선언할때 대입할 매개변수명이 객체의 필드명과 동일하면 생략가능
    //const obj = {name :name , kor : kor , math : math };
    const obj = { title , content};
    console.log(obj);


    //(*) fetch 대신에 axios 활용한 비동기통신 vs 동기화통신 , 상황에 따라 다르다.
    //(비동기)
    axios.post('/day04/task/board' , obj)
        .then(response => {console.log(response); onFindAll();})
        .catch(e => {console.log(e)})






//[2] 전체 조회 함수
const onFindAll = async () => {
    //(동기화) await , async
    try{
    const response = await axios.get('/day04/task/board')
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









// [3] 개별 수정 함수
const onUpdate = async (sno) => {

        //(1) 수장할 값 받기
        const title = prompt('새로운제목')
        const content = prompt('새로운 내용')
        //(2) 객체화
        const obj = { bno , title, content  };
        //(3) axios 통신
        const response = await axios.put('/day04/task/board' , obj)
        if( response.data == 1){ onFindAll()} // 만약에 응답 자료 내용이 1이면 수정 성공 -> 전체조회 함수 실행






// [4] 개별 삭제 함수
const onDelete = async (sno) => {
    // (1) 삭제할 번호 : sno
    // (2) axios 통신
    const response = await axios.delete(`/day04/task/board?sno=${sno}`)
    if(response.data == 1){ onFindAll();} //만약에 응답내용이 1이면 삭제 수정 -> 전체 조회함수 실행


}