
//First naive solution


//TODO: convert this to more idiomatic groovy next
def numDivisors(n) {
    if(n % 2 == 0) {
        n = n / 2
    }

    divisors = 1
    count = 0

    while(n % 2 == 0) {
        count += 1
        n = n/2
    }
    divisors = divisors * (count + 1)
    p = 3
    while(n != 1) {
        count = 0
        while(n % p == 0) {
            count += 1
            n = n / p
        }
        divisors = divisors * (count + 1)
        p += 2
    divisors
}

def find_triangular_index() {
    n = 1
    lnum = num_divisors(n)
    rnum = num_divisors(n + 1)
    while (lnum * rnum < 500) {
        n += 1
        lnum = rnum
        rnum = num_divisors(n + 1)
    }
    n
}

start = time.time()
index = find_triangular_index(500)
triangle = (index * (index + 1)) / 2
elapsed = (time.time() - start)

println "result %s returned in ${triangle} ${elapsed} seconds"
