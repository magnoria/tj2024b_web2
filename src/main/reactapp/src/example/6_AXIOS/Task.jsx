/*
    리액트 과제3 : 리액트 전화번호부 만들기
        조건1 : '이름' 이랑 '전화번호' 입력받아 Spring서버에게 전송 + myBatis
        조건2 : 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ol 또는 ul 로 모두 출력하시오.
        조건3 : useState 사용 , sueEffect 사용, axios 사용
    카카오톡 제출 : ip로 제출
*/

import axios from "axios";
import { useEffect, useState } from "react";

export default function Taskd(){

    // 데이터 저장 함수
    const[formData, setFormData] = useState({name: '' , number : ''})
    
    //입력받은 데이터 렌더링
    const formDataChange = (e) => {
       console.log(e);
        
        setFormData({...formData , [e.target.name] : e.target.value});

    }

    // 현재 변수를 스프링 서버에게 보내기
    const onPost = async (e) => {
            try {
                const response = await axios.post('http://192.168.40.63:8080/day07/task' ,formData) //
            if(response.data == true){alert("등록성공");
                setFormData({name : '' , number : ''});
                onFindAll();
            }else{alert('등록실패')};
            } catch (error) { console.log(error);
                
            }

    }

    useEffect(() => {onFindAll()}, []) // 실행을 안했음 여기가 실행부분

    const [boards, setBoards] = useState([]);

    //모든데이터 불러오기
    const onFindAll = async () => {
        try {
            const response = await axios.get('http://192.168.40.63:8080/day07/task');// 이거를 local로 할경우 외부에서 들어올수가 없다
            setBoards(response.data);

        } catch (error) { console.log(error);
            
        }
    }

    return(<>
        <div>
        <form>
         <h1>전화번호부</h1>
        <h3>이름</h3>
        <input type="text" value={formData.name} name="name" onChange={formDataChange} />
        <h3>전화번호</h3>
        <input type="text" value={formData.number} name="number" onChange={formDataChange}/><br/>
        <button type="button" onClick={onPost} >저장</button>
        </form>

        <table>
                <thead><tr><th>이름</th><th>전화번호</th></tr></thead>
                <tbody>
                    {
                        boards.map((board,index) => {
                            return(<tr key={index}>
                                <td>{board.name}</td>
                                <td>{board.number}</td>
                            </tr>)
                        })
                    }
            </tbody>
        </table>
            
                
           

                

            


        </div>
    
    
    </>)

}




