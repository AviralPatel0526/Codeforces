from collections import *
from math import *
from sys import *
from heapq import *

input = stdin.readline

def sinput():
    return int(input())

def linput():
    return list(map(int, input().split()))

def printl(l):
    return print(' '.join(map(str, l)))

def convertBits(l):
    for x in range(len(l)):
        l[x] = [*bin(l[x]).replace('0b', '')]
        l[x] = ['0'] * (32 - len(l[x])) + l[x]
        l[x] = l[x][::-1]

# GCD Method
def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

# LCM Method
def lcm(a, b):
    return (a // gcd(a, b)) * b

# Sieve of Eratosthenes Method
def sieve(n):
    is_prime = [True] * (n + 1)
    is_prime[0], is_prime[1] = False, False
    p = 2
    while (p * p <= n):
        if is_prime[p]:
            for i in range(p * p, n + 1, p):
                is_prime[i] = False
        p += 1
    return is_prime

# remember binary search
# bitwise operator -> bitmask
def solve():
    n,q=linput()
    li=linput()
    s=0
    s+=li[0]
    pre=[]
    pre.append(li[0])
    for i in range(1,n):
        pre.append(li[i]+pre[i-1])
        s+=li[i]
    for i in range(q):
        l,r,k=linput()
        if(l == 1):
            p_sum=pre[r-1]
            n_sum=k*(r)
            if s%2 == 0:
                if p_sum%2 != n_sum%2:
                    print("YES")
                else:
                    print("NO")
            else:
                if p_sum%2 != n_sum%2:
                    print("NO")
                else:
                    print("YES")

        else:
            p_sum=pre[r-1]-pre[l-2]
            n_sum=k*(l-r+1)
            if s%2 == 0:
                if p_sum%2 != n_sum%2:
                    print("YES")
                else:
                    print("NO")
            else:
                if p_sum%2 != n_sum%2:
                    print("NO")
                else:
                    print("YES")

            
        



for _ in range(int(input())):
    solve()