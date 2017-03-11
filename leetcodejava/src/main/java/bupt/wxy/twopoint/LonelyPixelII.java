package main.java.bupt.wxy.twopoint;

/**
 * Created by533. Lonely Pixel II My SubmissionsBack To Contest
 User Accepted: 29
 User Tried: 54
 Total Accepted: 30
 Total Submissions: 76
 Difficulty: Medium
 Given a picture consisting of black and white pixels, and a positive integer N, find the number of black pixels located at some specific row R and column C that align with all the following rules:

 Row R and column C both contain exactly N black pixels.
 For all rows that have a black pixel at column C, they should be exactly the same as row R
 The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

 Example:
 Input:
 [['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'W', 'B', 'W', 'B', 'W']]

 N = 3
 Output: 6
 Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
 0    1    2    3    4    5         column index
 0    [['W', 'B', 'W', 'B', 'B', 'W'],
 1     ['W', 'B', 'W', 'B', 'B', 'W'],
 2     ['W', 'B', 'W', 'B', 'B', 'W'],
 3     ['W', 'W', 'B', 'W', 'B', 'W']]
 row index

 Take 'B' at row R = 0 and column C = 1 as an example:
 Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
 Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are exactly the same as row R = 0.

 */

// 我觉得和I思想大致相同
public class LonelyPixelII {

    public int findBlackPixel(char[][] picture, int N) {
        return 0;
        /**
        int m,n;
        if((m=picture.length)==0||(n=picture[0].length)==0)return 0;

        int res=0;
        // 用来记录一个列有多少'B'
        int[] col_counts=new int[n];
        int[] row_counts=new int[m];
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++)
                if(picture[i][j]=='B'){
                    row_counts[i]++;
                    col_counts[j]++;
                }

        }

        for(int i=0;i<m;i++){
            // 多一个位置, 避免多的情况
            int[] indexs=new int[N];
            int index=-1;
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    index++;
                    if(index==N){
                        break;
                    }
                    indexs[index]=j;
                }
            }
            // 如果数量不对
            if(index!=N-1)continue;
            for(int k=0;k<N;k++){
                if(col_counts[indexs[k]]!=N)allCan=false;
            }
            if(allCan) {
                res += 3;
            }
        }
        return res;
        /**
        int m,n;
        if((m=picture.length)==0||(n=picture[0].length)==0)return 0;

        int res=0;
        // 用来记录每一行有多少个'B'
        int[] row_counts=new int[m];
        int[] col_counts=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                if(picture[i][j]=='B'){
                    row_counts[i]++;
                    col_counts[j]++;
                }
        }

        // 用来记录邻居
        int[][] row_indexs=new int[m][N];
        for(int i=0;i<m;i++) {
            if (row_counts[i] != N) continue;
            int index=-1;
            for(int j=0;j<n;j++)
                if(picture[i][j]=='B')row_indexs[i][++index]=j;
        }
        int[][] col_indexs=new int[n][N];
        for(int j=0;j<n;j++){
            if(col_counts[j]!=N)continue;
            int index=-1;
            for(int i=0;i<m;i++)
                if(picture[i][j]=='B')col_indexs[j][++index]=i;
        }
        for(int i=0;i<m;i++){
            if(row_counts[i]!=N)continue;
            for(int j=0;j<n;j++){

            }
        }




        for(int i=0;i<m;i++){
            // 多一个位置, 避免多的情况
            int[] indexs=new int[N];
            int index=-1;
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    index++;
                    if(index==N){
                        break;
                    }
                    indexs[index]=j;
                }
            }
            // 如果数量不对
            if(index!=N-1)continue;
            for(int k=0;k<N;k++){
                if(col_counts[indexs[k]]==N){
                    res++;
                }

            }
        }
        return res;
        /**
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(row_counts[i]==N&&col_counts[j]==N&&picture[i][j]=='B')res++;
        return res;
         **/

        /**
        int m,n;
        if((m=picture.length)==0||(n=picture[0].length)==0)return 0;

        int res=0;
        // 用来记录一列B的位置
        int[][] col_counts=new int[n][N];
        for(int j=0;j<n;j++){
            int index=0;
            for(int i=0;i<m;i++)

                if(picture[i][j]=='B'){
                    index++;
                    if(index==N)
                    col_counts[j][index]=i;
                }
        }


        for(int i=0;i<m;i++){
            // 多一个位置, 避免多的情况
            int[] indexs=new int[N];
            int index=-1;
            for(int j=0;j<n;j++){
                if(picture[i][j]=='B'){
                    index++;
                    if(index==N){
                        break;
                    }
                    indexs[index]=j;
                }
            }
            // 如果数量不对
            if(index!=N-1)continue;
            for(int k=0;k<N;k++){
                if(col_counts[indexs[k]]==N)res++;
            }
        }
        return res;
         **/
    }
}
