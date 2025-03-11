import { useEffect , useState } from "react"
import axios from 'axios'; //직접입력함

export default function Read( props ){

    //컴포넌트가 최초 실행될때 (딱 1번) 실행하는 생명주기 함수,
    useEffect(() => {
        console.log("여기는 컴포넌트가 실행될때 딱 1번만 호출됩니다.")
            axios.get('http://192.168.40.63:8080/day08/products')
            onRead(); // 컴포넌트가 열릴때 AXIOS 통신하여 데이터를 가져온다

    } , []) //최초 실행될때 한번만 실행하는것

    //[2] axios 이용하여 서버와 통신한다.
    const onRead = async () => {
        const response = await axios.get('http://192.168.40.63:8080/day08/products')
        console.log(response.data);
        setProducts(response.data); // 서버로투버 받은 모든 제품정보를 상태변수에 저장한다.
        
    }

    //[3] 서버로 부터 받은 결과를 저장하는 상태변수
    const [products , setProducts] = useState([])
    console.log(products)



    return(<> <div>
          <h3>Read 페이지</h3>
          <table>
                <thead>
                    <tr><th>번호</th> <th>제품명</th> <th>제품설명</th> <th>제품가격</th></tr>
                </thead>
                <tbody>
                    {
                        products.map((products, index) =>{
                            return(<tr>
                                <td>{products.id}</td>
                                <td>{products.name}</td>
                                <td>{products.coment}</td>
                                <td>{products.price}</td>
                            </tr>)


                        } )

                    }
                </tbody>
          </table>
         </div></>)
}