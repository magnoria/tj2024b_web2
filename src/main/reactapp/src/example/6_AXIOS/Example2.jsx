import { useEffect, useState } from "react"
import axios from "axios"; // 

export default function Exalple2 (props) {

    //[1] 입력받은 데이터를 저장하는 state 변수 ,{writer : '' , content : '' , pwd : ''} 초기값
    const[formData , setFormData] = useState( {writer : '' , content : '' , pwd : ''})
    // [2] 입력받은 데이터를 렌더링 하는 이벤트 함수
    const formDataChange = (e) => {
        console.log(e.target); // 이벤트를 발생한 html dom(마크업/태그)
        console.log(e.target.name); // 이벤트를 발생한 html dom의 name 속성 값 반환
        console.log(e.target.value);//이벤트를 발생한 html dom의 value 속성 값 반환
        // 스프레드 연산자를 이용한 state 변수 변경
        // 
        setFormData({...formData , [e.target.name] : e.target.value});
    }

    //[3] 현재 state 변수를 스프링 서버에게 보내기 , AXIOS
    const onPost = async (e) => {
        try {
            const response = await axios.post('http://localhost:8080/day07/task' , formData) // state변수를 axios로 보내기
            if(response.data == true){alert("등록성공"); // 알림
                setFormData({writer : '', content: '' , pwd : ''});//state 초기화
                onFindAll(); //등록 성공하면 자료 렌더링
            } else{alert('등록실패')};
                
        } catch (error) { console.log(error);}
    }

    //[4] 서버에 저장된 방문록 정보(작성자/내용/비밀번호 여러개) 요청한다.
    useEffect( () => {onFindAll}, []);// (1) 컴포넌트 마운트(생성) 될때 최초 1번 실행 //컴포넌트가 생성될때 딱 1번 onFindAll 함수가 실행된다.
    //useEffect( () => {onFindAll}, ); // onFindAll -> setBoards -> onFindAll -> setBoards 무한렌더링
    //useEffect( () => {onFindAll}, [boards]); // onFindAll -> setBoards -> onFindAll -> setBoards 무한렌더링
    
    const [boards ,setBoards] = useState([]); //여러개의 방문록을 가지는 state 변수

    const onFindAll = async () => {
       // (3) 주로 동기 통신 : async(e) => {await axios.메소드명()}
            // -> 서버의 도메인이 다름으로 '/day07/react' [오류발생] , 'http://localhost:8080/day07/react' [서버도메인까지 작성해야함]
        try {
        const response = await axios.get('http://localhost:8080/day07/task');
        setBoards(response.data); // 서버로부터 받은 정보를 state 변수에 저장 // 재렌더링
            
        } catch (error) { console.log(error); }           
    }

    return (<>
        <div>
            <h4> 입력 폼</h4>
            <form>
                작성자 : <input type="text" value={formData.writer} name="writer" onChange={formDataChange}/> <br/>
                방문록 : <input type="text" value={formData.content} name="content" onChange={formDataChange}/><br/>
                비밀번호 : <input type="text" value={formData.pwd} name="pwd" onChange={formDataChange}/><br/>
                <button type="button" onClick={onPost}>등록</button>
            </form>

            <table>
                <thead><tr><th>번호</th><th>작성자</th><th>방문록내용</th><th>비고</th></tr></thead>
                <tbody>
                    {
                        boards.map((board,index) => {
                            return (<tr key = {board.num}>
                                    <td>{board.num}</td> 
                                    <td>{board.writer}</td>
                                    <td>{board.content}</td>
                                    <td>수정/삭제</td>
                                    </tr>)
                        })
                    }
                </tbody>
            </table>

        </div>
       
    </>)
}





/*
  리액트 과제3 : 리액트 전화번호부 만들기
    조건1 : (저장) '이름' 이랑 '전화번호' 입력받아 배열에 저장 
    조건2 : (전체출력) 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ol 또는 ul 로 모두 출력하시오.
    조건3 : useState 사용. 
  카카오톡 제출 : ip로 제출 

  [1] .jsx 파일 생성 
  [2] 파일내 컴포넌트(함수) 생성 , 컴포넌트명 : 첫글자대문자 필수로 한다.
    export default function 컴포넌트명(){ 
      return (<></>)
    }
  [3] main.jsx 에서 생성한 컴포넌트 렌더링 
  [4] 입력 상자의 state 변수 , document.querySelector() 방식이 아닌.
    (1) 선언 방법 : const [ 변수명 , set변수명 ] = useState( 초기값 )
      -> 초기값 : 다양한 자료의 모든 타입 가능하다. 
          문자열 초기 : '' , 정수 초기 : 0 , 실수 초기 : 0.0 , 객체 초기 : { } , 배열 초기 : [ ]
        방법1
        const [ name , setName ] = useState(''); 
        const [ phone , setPhone ] = useState('');
        const [ members , setMembers ] = useState( [] );
        방법2
        const [ member , setMember ] = useState( { name : '' , phone : '' } ); 
        const [ members , setMembers ] = useState( [] );
        방법3
        const [ members , setMembers ] = useState( [ { name : '' , phone : '' } ] );

    (2) event(e) 이벤트 객체 
      onChange = ( event ) => { } , onChange 이벤트 실행 결과를 다음 함수의 매개변수로 전달 
      event.target : 이벤트 발생한 DOM(HTML마크업)
      event.target.value : 이벤트 발생한 DOM의 value 속성 반환 
    
    (3) setXXX( 새로운값 ) , ...스프레드연산자
      setXXX( event.target.value )
      setXXX( [...기존배열 , 새로운값 ] )
      
  [5] map 반복문 이용한 출력 
    {
      리스트/배열명.map( ( 반복변수명, 인덱스 ) => {
          return (<></>)
        })
    }
*/
/*export default function Task1(){ 
    // (1) 입력한 성명을 저장하는 state 변수 
    const [ name , setName ] = useState(''); // 성명 state 변수 선언 
    // (2) 입력한 연락처를 저장하는 state 변수 
    const [ phone , setPhone ] = useState('');
    // (3) 입력한 성명과연락처를 객체로 저장하는 배열 state 변수  
    const [ members , setMembers ] = useState( [] ); // 배열 초기값은 빈 배열 [ ]
    return (<>
      <h3> 리액트 과제 3 </h3>
      성명 : <input value={ name } onChange={ ( e )=>{ setName( e.target.value ); } } /> <br/>
      연락처 : <input value={ phone } onChange={ ( e )=> { setPhone( e.target.value );  } } /> <br/>
      <button 
        onClick={ ( e ) => { setMembers( [ ...members , { name , phone } ] ); setName('') , setPhone('') }  } > 
        등록 
      </button>
      <ul>
        {
          members.map( ( member, index ) => {
              return (<>
                <li> 성명 : { member.name } , 연락처 : { member.phone } </li>
              </>)
            })
        }
      </ul>
    </>)
  }*/