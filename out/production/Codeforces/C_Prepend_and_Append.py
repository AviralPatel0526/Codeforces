t=int(input())
while t!=0:
    t-=1
    n=int(input())
    s=input()
    i=0
    j=n-1
    while i<j:
        if(s[i]=='0' and s[j]=='1' or s[i]=='1' and s[j] == '0'):
            n-=2
        else:
            break 
        i+=1
        j-=1  
    print(n)