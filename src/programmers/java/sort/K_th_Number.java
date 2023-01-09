package programmers.java.sort;

//        배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
//
//        예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
//
//        array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
//        1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
//        2에서 나온 배열의 3번째 숫자는 5입니다.
//        배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
//        commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

import java.util.Arrays;

public class K_th_Number {

    public static void main(String[] args){

        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        int[] result = {5,6,3};

        int[] answer = solution(array, commands);

        for(int i=0; i< result.length; i++){
            System.out.println(i +"번 배열 일치 " +(result[i]==answer[i]));
        }


    }

    public static int[] solution(int[] array, int[][] commands){

//      답을 제출할 배열의 길이를 먼저 맞춰준다.
        int[] answer = new int[commands.length];

//      문제에서 제시한 변수대로 반복문을 돌려 각각 변수를 선언해준다.
        for(int m=0; m<commands.length; m++){
            int i = commands[m][0];
            int j = commands[m][1];
            int k = commands[m][2];
//          임시 배열인 temp 에 array 배열을 문제에서 제시한 대로 잘라 준다.
//          단 배열은 시작이 0번이므로 i에서 -1을 해주고, j 변수해당하는 index 번호 앞까지 해서 자르는데 index 는 0부터 시작함으로 조정하지 않아도 된다.
            int[] temp = Arrays.copyOfRange(array, i-1, j);
//          임시 배열인 temp 를 정렬 해준다.
            Arrays.sort(temp);

//          제출할 배열에 문제에서 원하는 k번째 즉 index 는 0부터 시작함으로 k-1을 하여 answer 배열에 저장
            answer[m] = temp[k-1];
        }

        return answer;

    }

}
