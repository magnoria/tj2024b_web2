
export default function Example1(props){
    
    //======================jsx 문법start ================
    return(
        <div>
            {/* 주석내용물 */}
            <h3> 컴포넌트</h3>
            {/* 다른 컴포넌트 호출 */}
            <Component1/>
            <Component2/>
            <Component3/>
            <Component4/>
            <Component5/>
            <Component6/>
            <Component7/>
        </div>


    )

    //=======================JSX 문법 end ===============


}// fend

//(2) 
function Component1(props){

    return <h4>한줄로 입력시 () 생략가능</h4>

}//f end

//(3)
function Component2(props){
    return (
        <div>
             <h4>두줄로 입력시 () 필수로 감싼다.</h4>
        </div>

    )


}// f end

//(4)
function Component3(props){
    return (<>
        <h4> div 대신에 이름없는 마크업 사용이 가능하다.</h4>
            </>)

}

//(5)
function Component4(props){
    const name = '유재석'
    const age = 40;
    const obj = { name : '강호동' , age : 50}

    return(
        <div>
            <h4>{name} 님의 나이 : {age}</h4>
            <h4>{obj.name} 님의나이 : {obj.age}</h4>
        </div>
    )

}//f end

//(6)
function Component5(props){
    const loginState = true; // 로그인 상태
    //JSX 문법 { } 표현식에서는 if, for, fuction, const, let 불가능하다.
    return(
        <div>
            <h4>{loginState == true ? '로그인중' : '비로그인중'}</h4>
            <h4>{loginState && <p>로그인 상태일때만 보이는 메시지</p>}</h4>
        </div>
    )
}

//(7)
function Component6(props){
    const items = ['사과' , '딸기' , '바나나']
    // JSX 문법의 목록(li , option 등등) 마크업들에는 key 속성을 필요로 한다.
        // => 리액트는 자동렌더링(새로고침) 할때 key 변화를 감지하여 변환된 key만 별도로 렌더링하는 기능 포함
    // JSX 문법에서는 forEach 함수 보다 map 함수를 더 자주 사용한다. 
    return(
        <>
        <ul>
            { /*jsx 표현식 시작*/

                items.map(
                    (item, index) => (
                    <li key={index}> {item}</li>
                    )//jsx
                
                )// 맵 end

            }
        </ul>
        </>
    )
}

//(8)
import'./Eample1.css'// * css 파일 impor // import '경로/파일명.css'
function Component7(props){
    // style 속성에 style = "color : blue" [x]
    // style 속성에 style ={{css객체}} [0] 주의할점 : css 카멜표기법, JS의 속성은 -하이픈 사용하지 못하므로 주의하기
    const cssObj = {color : 'red'}
    // class 속성이 아닌 className 사용한다.
    return (
        <>
        <h4 style={{color : "blue"}}>인라인 형식의 css 넣기</h4>
        <h4 style={cssObj}> 인라인 형식의 객체 CSS 넣기</h4>
        <h4 className="myclass">CSS파일내 선택자 이용한 CSS 넣기</h4>
        </>
    )
}                                                                                                                         