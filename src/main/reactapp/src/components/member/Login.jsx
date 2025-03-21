import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router-dom";

import {useDispatch} from 'react-redux'; // 전역 함수 불러오기
import { login } from "../reduxs/userSlice";

export default function Login(Props){

    // (*) 리덕스 (전역변수) 사용하기.
    // (1) 리덕스 사용하기 위한 useDispatch 함수 가져오기
    const dispatch = useDispatch();

    // (1) 입력받은 값들을 저장하는 state변수
    const [memberInfo , setMemberInfo] = useState({mid :'', mpwd : ''})
    // (2) 입력받은 값들을 수정하는 state 수정처리 함수
    const onIputChange = (event) => {setMemberInfo({...memberInfo, [event.target.name] : event.target.value});}
    // (3) 입력받은 값들을 axios 이용하여 자바(스프링)에게 요청과 응답받기
    const navigate = useNavigate();
    const onLogin = async () => {
        const response = await axios.post('http://localhost:8080/api/member/login', memberInfo , {withCredentials : true})// memberInfo를 안넣으면 missingbody 오류가 뜸
        // 도메인이 달라서 withCredentials : true 이걸 넣음 
        const result = response.data;
        if(result == true){
            //(4) 로그인 성공할경우 로그인 성공한 회원 정보를 가져오기
            const response2 = await axios.get('http://localhost:8080/api/member/info' , {withCredentials : true})

            alert("로그인성공"); navigate("/");
            dispatch(login(response2.data));
           // navigate("/")//navigate("/") :새로고침없다 vs location.href="/":새로고침 있다. dom에서 지원을 해준다
           //location.href="/"; // 바꾸는 이유 이것도 바꿈
           // (*) 리덕스 (전역변수) 사용하기.
           // (2) useDispatch 함수를 이용한 리듀서 함수 액션하기. // 로그인 액션(함수)에 (로그인한)회원정보를 대입한다. // 전역변수 대입
           //dispatch(login(response.data)); // useState(지역상태)가 아닌 store(전역상태)에 저장된다. setMemberInfo를 안쓰고 전역으로 저장
           //setMemberInfo(response.data); //지역변수 느낌으로 사용
        }
        else{alert("로그인실패");}
    }

    console.log(memberInfo);

    return(<>
    <h3>로그인페이지</h3>
        <form>
            아이디 : <input type="text" name="mid" value={memberInfo.mid} onChange={onIputChange}/><br/>
            비밀번호 : <input type="password" name="mpwd" value={memberInfo.mpwd} onChange={onIputChange}/><br/>
            <button type="button" onClick={onLogin}>로그인</button>
        </form>
        </>)
}