#include<iostream>
#include<cstdio>
#include<cstring>
#include<cmath>
#include<algorithm>
using namespace std;

struct data{
    long long pos;
    long long val;
}a[100010];
long long sum[100010];
long long sum2[100010];
long long n,m;

bool cmp(data a,data b){
    return a.pos<b.pos;
}

int main(){
    int i,j,k;
    cin>>m>>n;
    for(i=1;i<=n;i++)
        cin>>a[i].pos>>a[i].val;
    sort(a+1,a+1+n,cmp);
    long long ans=-1;
    for(i=1;i<=n;i++){
        sum[i]=sum[i-1]+(long long)a[i].pos*a[i].val;
        sum2[i]=sum2[i-1]+a[i].val;
    }
    for(i=1;i<=n;i++){
        long long tmp=sum2[i-1]*a[i].pos-sum[i-1];
        tmp+=sum[n]-sum[i]-(sum2[n]-sum2[i])*a[i].pos;
        if(ans==-1||ans>tmp)
            ans=tmp;
    }
    cout<<ans<<endl;
    return 0;
}