import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// import './index.css'
// import App from './App.jsx'

// react18 버전일때 버전마다 차이가 심함
//유효성 검사   <StrictMode> 
///createRoot(document.getElementById('root')).render(
  //<StrictMode> 
    //<App />
  //</StrictMode>,
//)

// (*)index.html에 root 구역 가져오기.
const root = createRoot(document.querySelector('#root'))

//day01 : '컴포넌트 만들기' 렌더링
  // import 호출할컴포넌트명 from '경로/파일명(확장자)';
//import Component1 from './example/1_동작구조/Component1.jsx'
//root.render(<Component1/>) //닫기 버튼 꼭 넣어야함


//day01 : 여러컴포넌트 만들기
//import Component2 from './example/1_동작구조/Component2.jsx'
//root.render(<Component2/>)

//day02 : 컴포넌트의 JSX 활용
//import Example1 from './example/2_컴포넌트/Example1.jsx'
//root.render(<Example1/>)

//day02: 컴포넌트의 Props 활용
//import Example2 from './example/2_컴포넌트/Example2.jsx'
//root.render(<Example2/>)

//Task day02 : 실습1
//import Task from './example/2_컴포넌트/task.jsx'
//root.render(<Task/>)

//day03 : 생명주기1
//import Example1 from './example/3_훅/Example1.jsx'
//root.render(<Example1/>)

//day03 :  생명주기2
// import Example2 from './example/3_훅/Example2.jsx'
// root.render(<Example2/>)

//day03 : 생명주기3
// import Example3 from './example/3_훅/Example3.jsx'
// root.render(<Example3/>)

// day03 : 과제
// import Task1 from './example/3_훅/Task1.jsx'
// root.render(<Task1/>)

// day03 : 과제
// import Task2 from './example/3_훅/Task2.jsx'
// root.render(<Task2/>)

// day04 : 생명주기4
// import Example1 from './example/4_훅2/Example1.jsx'
// root.render(<Example1/>)

// day04 : 라우터 
// import App from './example/5_라우터/Exalple1.jsx'
// root.render(<App/>)

// day05 : axios 1
// import Example1 from './example/6_AXIOS/Example1'
// root.render(<Example1/>)

// day05 : axios 2 
// import Exalple2 from './example/6_AXIOS/Example2'
// root.render(<Exalple2/>)


// import Taskd from './example/6_AXIOS/Task'
// root.render(<Taskd/>)

//day06 : 라우터 컴포넌트 렌더링
// import App from './example/7_AXIOS2/App'
// root.render(<App/>)

// day07 : 
// import Example1 from './example/8_MUI/Example1'
// root.render(<Example1/>)

import Example2 from './example/8_MUI/Example2'
root.render(<Example2/>)