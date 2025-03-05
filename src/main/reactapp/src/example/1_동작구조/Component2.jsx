
//(1) function
//(2) 컴포넌트 명 정의한다. (아무거나 단 첫글자는 대문자로 !!)
//(3) (props){} : 매개변수는 props 필수로 한다. (생략가능)
//(4) {return jsx문법을 사용한다.} : jsx 문법 작성
//(5) export default 반환할컴포넌트명 : 여러 컴포넌트 중에서 inport 할경우 반환할 컴포넌트를 정의한다.

//[1] 기본 컴포넌트
function Component2(props){
     return <div> <Header/> 메인페이지<Footer/> </div>

}

export default Component2;

//[2] 그외 컴포넌트
    //(1) 헤더 컴포넌트
function Header(props){
    return <div>헤더메뉴</div>

}

function Footer(props){
    return <div>푸터메뉴</div>

}