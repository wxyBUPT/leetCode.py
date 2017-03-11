package main.java.bupt.wxy.twopoint;

/**
 * Created by xiyuanbupt on 3/5/17.
 531. Lonely Pixel I

 Difficulty: Medium
 Given a picture consisting of black and white pixels, find the number of black lonely pixels.

 The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

 A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

 Example:
 Input:
 [['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

 Output: 3
 Explanation: All the three 'B's are black lonely pixels.
 */
// 并没有想到最优的办法, 尝试使用遍历
public class LonelyPixelI {

    public int findLonelyPixel(char[][] picture) {
        int m,n;
        if((m=picture.length)==0||(n=picture[0].length)==0)return 0;
        int res=0;
        for(int i=0;i<m;i++){
            int index=-1;
            boolean moreThanOne=false;
            // 第一遍遍历, 看行是否有多个B
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    if(index==-1){
                        index=j;
                    }
                    else {
                        moreThanOne=true;
                    }
                }
            }
            // 如果有多个B则continue
            if(moreThanOne||index==-1)continue;
            // 查看index列是否有多个B
            int count=0;
            for(int j=0;j<m;j++){
                if(picture[j][index]=='B')count++;
            }
            if(count==1)res++;
        }
        return res;
    }
}
