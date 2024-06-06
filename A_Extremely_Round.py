t=int(input())
while t!=0:
    t-=1
    n=int(input())
    if n<=10:
        print(n)
    elif(n > 10 and n <= 100):
        print(9+n//10)
    elif(n > 100 and n <= 1000):
        print(9 + 9 + n//100)
    elif(n > 1000 and n <= 10000):
        print(9+9+9+n//1000)
    elif(n > 10000 and n <= 100000):
        print(9+9+9+9+n//10000)   
    else:
        print(9+9+9+9+9+n//100000)         

