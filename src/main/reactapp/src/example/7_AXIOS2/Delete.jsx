import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"

export default function Delete( props ){
    
    const[deleteId , setDleteId] = useState('')
    const onValueChange=(e) => {
        setDleteId(e.target.value);
    }

    const navigate = useNavigate();
    const onDelete = async () => {
        const response = await axios.delete(`http://192.168.40.63:8080/day08/products?id=${deleteId}`)
        if(response.data == true){alert('삭제성공'); navigate('/read');}
        else{alert('삭제성공:없는제품번호이거나 시스템오류');}
    }
    
    
    
    return(<> <div> 
        <h3>Create 페이지</h3>
        <form>
            삭제할제품번호 : <input value={deleteId} onChange={onValueChange}/>
            <button type="button" onClick={onDelete}>삭제</button>
        </form>
        </div> </>)
}