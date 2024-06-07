t=int(input())
while t!=0:
    t-=1
    n,k=map(int,input().split())
    s=input()
    mp={}
    for c in s:
        if c in mp:
            mp[c]+=1
        else:
            mp[c]=1
    odd=0        
    for key in mp:
        if mp[key]%2 == 1:
            odd+=1
    if odd > k+1:
        print("NO")
    else:
        print("YES")