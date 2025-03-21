import axios from "axios";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import{useDispatch, useSelector} from 'react-redux'; // 전역변수 불러오기
import { logout } from "../reduxs/userSlice";

export default function Header(Props){
    
    //(*************************************) 리덕스 (전역변수)사용하기
    //(1) (전역상태)에서 로그인 회원정보 불러오기
    const loginInfo = useSelector((state) => state.user.userInfo)
    console.log(loginInfo);// 확인
    
    // //(1) 로그인 상태를 저장하는 state 변수 , 객체를 저장할 예정이라 빈객체{} 를 초기 값으로 선언
    // const[ login, setLogin] = useState({}); // 위에 userInfo 가 있기에 이거는 필요 없어졌다
    // //(2) axios 이용하여 서버에게 로그인 상태 요청하고 응답받기 
    // const onLoginInfo = async()=>{
    //     // 1. axios 이용하여 서버요청후 응답 받기
    //     const response = await axios.get('http://localhost:8080/api/member/info' , {withCredentials : true}) // {withCredentials : true} 세션 허용위해서 도메인이 다를 때
    //     // 2. 응답의 본문(결과) 반환
    //     const result = response.data;
    //     console.log(result);
    //     // 3. 응답결과를 state 변수에 저장
    //     setLogin(result);
    // }
    // // (3) useEffect 이용하여 onLoginInfo 함수 실행 , useEffect(()=>{} ,[])  : 컴포넌트가 최초 렌더링 될때 1번 실행
    // useEffect(()=>{onLoginInfo()} ,[])  ---> 안써도 되는 이유 전역 변수를 만들었기때문에 회원정보를 가져올 필요가 없다. 로그인상태 변수 및 함수가 필요없다.

    //(2)
    const dispatch = useDispatch();

    // (4) axios 이용하여 로그아웃 요청과 응답받기
    const navigate = useNavigate();
     const onLogout = async () => {
        const response = axios.get('http://localhost:8080/api/member/logout' , {withCredentials : true})
        alert('로그아웃 했습니다');
        navigate('/');
        //location.href="/" // 다시 랜더링이 필요해서 location 사용 
        dispatch(logout());
     }

    // 로그인/로그아웃 했을때 재렌더링이 필요하다.
    return(<>
        
            <div>
                
                <ul>
                    <li>
                        {loginInfo ? (<>
                        <div>{loginInfo.mid}님 안녕하세요.
                                <button onClick={onLogout}>로그아웃</button>
                            </div> 

                        </>)
                        : 
                        (<><div>비로그인중</div></>) // 두줄이상은 무조건 () 하기
                        }
                    </li>
                    <li> <Link to="/">홈으로</Link></li>
                    <li> <Link to="/member/signup">회원가입</Link></li>
                    <li> <Link to="/member/login">로그인</Link></li>
                </ul>
               
            </div>
    </>)
}