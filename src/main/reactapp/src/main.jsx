import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

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
import Component1 from './example/1_동작구조/Component1.jsx'
//root.render(<Component1/>) //닫기 버튼 꼭 넣어야함


//day01 : dufj zjavhsjsxm aksemfrl
import Component2 from './example/Component2.jsx'
root.render(<Component2/>)