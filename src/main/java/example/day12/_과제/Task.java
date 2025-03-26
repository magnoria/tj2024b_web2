package example.day12._과제;

//List<String> 과일들 = List.of("사과", "바나나", "체리", "대추", "포도");
//
// 1.[메소드 레퍼런스 사용안함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
// 2.[메소드 레퍼런스 사용안함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
// 3.[메소드 레퍼런스 사용안함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
//
//4.[메소드 레퍼런스 사용안함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.
//
// 5.[메소드 레퍼런스 사용함]  forEach함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
// 6.[메소드 레퍼런스 사용함]  map함수를 활용하여 과일들을 하나씩 console에 출력하시오.
//
//7.[메소드 레퍼런스 사용함]  filter함수를 활용하여 과일들 중에 '바나나' 또는 '대추'만 console에 출력하시오.
//
// 8.[메소드 레퍼런스 사용함]  sorted함수를 활용하여 과일들을 내림차순으로 정렬하여 하나씩 console에 출력하시오.

import java.util.Comparator;
import java.util.List;


public class Task {
    static List<String> 과일들 = List.of("사과", "바나나", "체리", "대추", "포도");

    public static void main(String[] args) {
        //1.
//        과일들.forEach(x -> System.out.println(x));
        //2.
//        과일들.stream().map(x -> x).forEach( x-> System.out.println(x));
        //3.
//       과일들.stream().filter(x -> x == "바나나" || x == "대추").forEach(x-> System.out.println(x));
        //4.
//        과일들.stream().sorted().forEach(x-> System.out.println(x));
        //5.
//        과일들.stream().forEach(x-> System.out.println(x));
        //6.
//        과일들.stream().map(x ->x).forEach(x-> System.out.println(x));
        //7.
//        과일들.stream().filter(x-> x=="바나나" || x=="대추").forEach(x-> System.out.println(x));
        //8.
        과일들.stream().sorted(Comparator.reverseOrder()).forEach(x-> System.out.println(x));

    }




}
