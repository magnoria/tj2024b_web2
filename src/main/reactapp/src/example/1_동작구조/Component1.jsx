/*

    [1]컴포넌트 만들어서 렌더링 해보기
        1. 지정한 폴더에 첫글자를 대문자로 하여 .js 또는 .jsx(권장) 확장자 파일을 만든다.
        2. 함수형 컴포넌트(권장) vs 클래스형 컴포넌트
        3. return 에서 jsx(HTML과 JS 합쳐진) 문법을 활용하여 화면을 구현한다.
        JSP[HTML과 JAVA합쳐진것]
        4. 함수형 컴포넌트 반환한다. export default 컴포넌트명;
*/

//import React from "react";// js에서는 필수고 jsx(17이상) jsx에서는 생략이 가능하다.


function Component1(){
    return <div> 내가만든 컴포넌트 </div>

}


export default Component1;