
let a = 0 // 전역변수 //함수 밖에

export default function Example1(props){
    let b = 0;// 지역변수 // 함수안에
    ++a;// a에 1 증가
    ++b;// b에 1증가


    return (<>
        <h3> {++a}</h3>
        <h3> {++b}</h3>


        </>)
    }