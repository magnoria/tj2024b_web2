import axios from "axios"
import { useState } from "react"
import { Navigate, useNavigate } from "react-router-dom"

export default function Update( props ){

    const [productForm , setProductForm] = useState({ id : '' , name : '', price : '', comment : '' })
    const onValueChange = (e) => {
        setProductForm({...productForm,[e.target.name] : e.target.value});

    }

    const navigate = useNavigate();
    const onUdate = async () => {
        const response = await axios.put('http://192.168.40.63:8080/day08/products', productForm)
        if(response.data == true){alert('수정성공'); navigate('/read');}
        else{alert('수정실패: 없는제품번호 이거나 시스템오류')}
    }




    return(<><div>
        <h3> Update 페이지</h3> 
        <form>
            수정할제품번호: <input name="id" value={productForm.id} onChange={onValueChange}/><br/>
            수정할제품명:<input name="name" value={productForm.name} onChange={onValueChange}/><br/>
            수정할가격: <input name="price" value={productForm.price} onChange={onValueChange}/><br/>
            수정할설명: <textarea name="comment" value={productForm.comment} onChange={onValueChange}></textarea><br/>
            <button type="button" onClick={onUdate}>수정</button>
        </form>
        </div></>)
}