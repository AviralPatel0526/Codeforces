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
    n,k=linput()
    l=linput()
    l.sort()
    c=1
    mx=0
    for i in range(n-1):
        if (l[i+1]-l[i] > k):
            mx=max(mx,c)
            c=1
        else:
            c+=1
    mx=max(c,mx)
    print(n-mx)

for _ in range(int(input())):
    solve()