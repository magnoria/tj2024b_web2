 

import'./Task.css'
const ProductCard = ( props ) => {
        const lists = props.list;
        console.log(lists);
        
        let Stock;
        if( lists.inStock == true){
               Stock = lists.inStock;
               Stock = "재고있음";
        }else{
            Stock = "재고없음";
        }

    return (<>
            <div className="Task2">
            <h2>{lists.title}</h2> {lists.price} {Stock}
            </div>
            </>);
        
  };
  
  export default function Task( props ) {
    const products = [
      { title: "무선 키보드", price: 45000, inStock: true },
      { title: "게이밍 마우스", price: 32000, inStock: false },
      { title: "27인치 모니터", price: 280000, inStock: true }
    ];

    return (<div className='Task'>
        {   
            products.map(
                (product, i) => (
                   <ProductCard key={i} list={product}/>
                   
                )


            )
           
        }
        
    
    </div>)
  }