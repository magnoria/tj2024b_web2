console.log("task확인");

// 1. let과 const를 사용해서 name(이름)과 age(나이)를 저장하고 값을 출력해 보세요.
let name3 = "rdeo";
let age3 = "25"

let name4 = "fortun"
let age4 = "33"

const obj = { name3, age3 }
console.log(obj);
const obj2 = {name4 , age4}
console.log(obj2);

// 2. 숫자 두 개를 받아서 곱한 값을 반환하는 화살표 함수를 작성하세요.

const fun = ( obj, obj2) => {
    result  = obj * obj2;
    return result;
}

// 3. name과 age를 활용해서 "저는 [이름]이고, [나이]살입니다." 를 출력하세요.
const name5 = "Alice";
const age = 25;

console.log("저는" + name5 + "이고 ," + age + "살입니다." );


// 4. user 객체에서 name과 email 값을 추출해 변수를 만들고 출력하세요.
const user = { name: "Alice", email: "alice@example.com", age: 25 };


console.log(user.name , user.email);

// 5. arr1과 arr2를 합쳐 result 배열을 만드세요.
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

const respon = [arr1 + "," + arr2];

const result = {respon};
console.log(result);
// 6. greet 함수가 name 값을 받지 않으면 "Guest" 라고 출력하도록 만드세요.
const greet = (name) => `Hello, ${name}!`;
console.log( greet && 'Guest')
// 7. 객체를 만들 때 name, age 변수를 그대로 사용하세요.
const name2 = "Alice";
const age2 = 25;

const test = {name2 ,age2}
console.log(test)
// 8. 첫 번째 값을 first, 나머지를 rest에 저장하세요.
const numbers = [10, 20, 30, 40];

const [first, ...rest] = numbers;
console.log(first)
console.log(rest)
// 9. isLoggedIn이 true면 "Welcome!", false면 "Please log in."을 출력하세요.
const isLoggedIn = true;
console.log( isLoggedIn === true ? "welcom" : "Pleas lon in.")
// 10. 동기 fetch를 사용해서 JSONPlaceholder API에서 https://jsonplaceholder.typicode.com/posts/1 데이터를 가져오세요.
const test2 = async () => {
    try{
        const response = await fetch('https://jsonplaceholder.typicode.com/posts/1');
        const data = await respon.json();
       
    }catch(error){}
    console.log(data);
}

// 11. 배열 ages에서 각 나이를 기준으로 "성인" 또는 "미성년자"를 판단하여 새로운 배열을 만들어 출력하세요.
const ages = [25, 12, 20, 8];


for(let i =0; i <= ages.length-1; i++){
    if( ages[i] > 19){
       console.log(ages[i] + "성인입니다.")
      

    }else{console.log(ages[i] + "미성년자입니다.") }
   
}
