from collections import *
from math import *
from sys import *
from heapq import *

input = stdin.readline

def linput():
    return list(map(int,input().split()))

def printl(l):
    return print(' '.join(map(str,l)))

def convertBits(l):
    for x in range(len(l)):
        l[x] = [*bin(l[x]).replace('0b', '')]
        l[x] = ['0']*(32-len(l[x]))+l[x]
        l[x] = l[x][::-1]

# remember binary search
# bitwise operator -> bitmask
def solve():
    n,k,x=linput()
    z=n-k
    mx=n*(n+1)//2-z*(z+1)//2
    mna=k*(k+1)//2
    if (x >= mna and x <= mx):
        print("YES")
    else:
        print("NO")

for _ in range(int(input())):
    solve()


    
