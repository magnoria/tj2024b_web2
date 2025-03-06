/*
    리액트 과제 2 : 아래 코드들을 사용하여 입력된 값들의 글자수를 실시간으로 출력하시오.

*/

import { useState } from "react"

export default function Task1() {
    


    // (1) 여기에 state 변수 만들기
    // let [ 변수명 , set변수명] = useState(초기값);
        // - 변수명 : 아무거나 .(임의)
        // - set변수명 : set변수명(카멜표기법)
            // -> set변수명(새로운값)
        // - =useState(초기값) : 모든 타입의 자료 가능하다.

    let [char , setchar] = useState('');
    const[ msgList ,setMsgList] = useState([]);
    const 저장함수 = (e) =>{
        msgList.push(cahr); //입력받은 값이 저장된 state인 'char'를 msgList 저장
       // setMsgList(msgList); 
        // 기본타입 자료는 리터럴이라서 그 값 그자체 -> 기본타입 자료가 변경되면 그 값 그자체가 변경
        // 참조타입 자료는 안에 있는 자료가 변경되더라도 -> 참조타입 자체는 변경되지 않았다.
            // -> 리스트 안의 객체가 변경된것이지 리스트가 변한건 아니기에
            //setMsgList 가 되지 않음
            //그러므로 복제/복사 하므로써 자료의 주소값 새롭게 생성
            //복사방법 : 1.map 2. ...스프레드연산자 3. pre
        setMsgList([...msgList])
        console.log(setMsgList);
        //setMsgList( (msgList) => [...msgList, msg])
    }

    const handleChange = (eventObj) => {
        // (2) 여기에서 state 변수값 수정하기.
        console.log(eventObj);
        setchar(eventObj.target.value); //[eventObj.target]input -> onChange -> handleChange


    }

    return (
        <>
            <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
            <input value={char} onChange={handleChange}/>
            <p>글자 수: {char.length} </p>

            <h1>입력받은 값 배열에 저장</h1>
            <button onClick={저장함수}> 저장 </button>
        </>
    )
}