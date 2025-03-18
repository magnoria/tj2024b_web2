import { use, useState } from "react"
import axios from 'axios';
import { Navigate, useNavigate } from "react-router-dom";



export default function Signup(Props){
    // (1) 입력받은 값들을 저장하는 state변수선언, const [변수명, set변수명] = useState(초기값)
    // memberInfo는 일반적으로 (자바)memberDto의 멤버변수와 동일하게
    const [ memberInfo , setMemberInfo] = useState( {mid : "" , mpwd : "" , mname : "", }) 

    // (2) 입력받은 값들을 state 렌더링 하는 함수 , event :onChange 결과 정보 , event.target : 해당함수를 실행싵킨 마크업
    const onIputChange = (event) => {
        setMemberInfo({...memberInfo, [event.target.name] : event.target.value})
    } 

    // // (3) 입력받은 첨부파일
    // const onFileChange = (event) => {
    //     console.log(event.target.files[0]); //사용자가 입력한 파일객체 반환// js에서 file 클래스 제공
    //     // memberInfo는 일반적으로 (자바)memberDto의 멤버변수와 동일하게
    //     setMemberInfo({...memberInfo, "uploadfile" : event.target.files[0]})// 사용자가 입력한 파일객체를 state에 대입
    // } // f end
    // console.log(memberInfo);

    // (3) 입력받은 첨부파일* 첨부파일의 미리보기
    const[profile , setProfile] = useState(null); //업로드 파일을 파일객체로로 저장하는 state 변수
    const[preview , setPreview] = useState(null); //업로드 파일을 바이트로 저장하는 state 변수
    const onFileChange = (event) => { console.log(event.target.files[0])//사용자가 입력한 파일객체를 반환
        //1. 업로드된 파일 반환
        const file = event.target.files[0];
        //2. state 저장
        setProfile(file)
        //3. *이미지 미리보기 (업로드 x)
        if(file){
            //4. 파일 읽기 객체 선언
            const reader = new FileReader(); // js객체 : 파일 읽기 객체
            //5. 파일 읽기 메소드 정의 .reader.onloadend(()=> {파일읽어드릴때 실행할 코드})
            reader.onloadend = () => {
                console.log(reader.result); //읽어드린 파일을 출력 ,reader.result : 가져온 파일의 결과물(바이트)
                setPreview(reader.result); //state에 저장
            
            }
            //6. 파일 읽기
            reader.readAsDataURL(file) //읽어드릴 파일 대입, reader.readAsDataURL(file객체)
        }else{// 파일이 없으면
             setPreview(null);
        }

    }




    //(4) 입력받은 값들을 axios 로 보내고 응답받기
    const navigate = useNavigate();
    const onSignup = async () => {
        //1. formdata 객체 만들기 , json과 다르게 문자열 전송이 아닌 바이트(바이너리) 전송을 하기위한 폼전송
        const formData = new FormData()
        //2. fordata 에 속성 넣기 m .append('속성명', 값)
        formData.append('mid', memberInfo.mid);
        formData.append('mpwd', memberInfo.mpwd);
        formData.append('mname', memberInfo.mname);
        // *만약에 첨부파일이 존재하면 첨부파일 추가
        if(profile != null){
        formData.append('uploadfile', profile);
        }

        
        console.log("formData확인" + formData.data);
        for(const x of formData.entries()){
            console.log(x);
        }

        // 3. axios 에서 사용할 hhtp 헤더 정보 , axios 에서는 application/json은 기본값 이므로 할 필요없다.
        const option = {headers : {"Content-Type" : "multipart/form-data"}}
        // 4. axios 동기
        const response = await axios.post("http://localhost:8080/api/member/signup" , formData , option)
        //5. 응답받기
        const result = response.data;
        //6. 응답에 따른 처리
        if(result == true){
            alert("회원가입성공");
            // Navigate("/logib") : 새로고침없다 vs location.href="/login";
            navigate('/member/login');
        }
        else{alert('회원가입실패')}
    }
    

    return(<>
    <h3>회원가입페이지</h3>
    <form>
        아이디 : <input type="text" name="mid" value={memberInfo.mid} onChange={(e)=>{setMemberInfo({...memberInfo,[e.target.name] : e.target.value})}}/> <br/>
        비밀번호 : <input type="password" name="mpwd" value={memberInfo.mpwd} onChange={onIputChange}/> <br/>
        닉네임 : <input type="text" name="mname" value={memberInfo.mname} onChange={onIputChange}/> <br/>
        프로필 : <input type="file" accept="image/*" onChange={onFileChange}/> <br/>
        {
            preview && (<>
             미리보기 : <img src={preview}
                        style={{width:"100px"}}/>
             </> )
        }
        <br/>
        <button type="button" onClick={onSignup}> 회원가입 </button>
    </form>
    </>)
}