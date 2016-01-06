import groovy.time.TimeCategory
import groovy.time.TimeDuration

//First naive solution

//TODO: convert this to more idiomatic groovy next
def numDivisors(int n) {
    if (n % 2 == 0) {
        n = n / 2
    }

    divisors = 1
    count = 0

    while (n % 2 == 0) {
        count += 1
        n = n / 2
    }
    divisors = divisors * (count + 1)
    p = 3
    while (n != 1) {
        count = 0
        while (n % p == 0) {
            count += 1
            n = n / p
        }
        divisors = divisors * (count + 1)
        p += 2
        divisors
    }
}

def findTriangularIndex(limit) {
    n = 1
    lnum = numDivisors(n)
    rnum = numDivisors(n + 1)
    while (lnum * rnum < limit) {
        n += 1
        lnum = rnum
        rnum = numDivisors(n + 1)
    }
    n
}


def timeStart = new Date()

index = findTriangularIndex(500)
triangle = (index * (index + 1)) / 2

def timeStop = new Date()
TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
println "result %s returned in ${triangle} ${duration} seconds"
