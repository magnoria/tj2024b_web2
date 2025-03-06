/*
    리액트 과제3 : 리액트 전화번호부 만들기
        조건1 : '이름' 이랑 '전화번호' 입력받아 배열에 저장
        조건2 : 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ol 또는 ul 로 모두 출력하시오.
        조건3 : useState 사용
    카카오톡 제출 : ip로 제출
*/

import { useState } from "react"




export default function Task2(props){

    const [ name , setName] = useState('');
    
    const svNme = (event) => {
        console.log(event);

        setName(event.target.value);
    }

    const [ num , setNum] =  useState('');
    const svNum = (event) => {
        console.log(event);
        setNum(event.target.value)
    }


    const[ allList , setAll] = useState([]);
    //저장함수
    const 저장함수 = (e) => {

        allList.push({name,num});
        
        setAll( [...allList] );
        console.log(allList);
        
        
    }


    return <>
        <h1>전화번호부</h1>
        <h3>이름</h3>
        <input value={name} onChange={svNme}/>
        <h3>전화번호</h3>
        <input value={num} onChange={svNum}/><br/>
        <button onClick={저장함수}>저장</button>
            
        <div>
            <ul>
                
             { allList.map((list , i) => {
                return <li> 이름 : {list.name} , 전화번호 : {list.num}</li>
             }  )}
            
            

                

            </ul>


        </div>
    
    </>


}//f end
