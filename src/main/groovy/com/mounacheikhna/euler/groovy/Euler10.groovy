

solution1()
solution2()

void solution1() {
    //N = 2000000
    N = 20

    candidates = [0] * (N-2)

    for (long i = 2; i < N; i++) {
        if (candidates[i as int] == 0) {
            for (long j = i*i; j < N; j += i) {
                candidates[j as int] = 1
            }
        }
    }

    primes = []
    candidates.eachWithIndex { v, idx -> if (!v) primes << idx }

    primes.inject(-1 as long) { acc, val -> acc + val}
    println "Solution 1 : $primes"
}

void solution2() {
    def range = 1..20 //2000000
    def primes = range.findAll{n -> isPrime(n)}.inject(0l,{x,accum-> x+accum})
    println "Solution 2 : $primes"
}

def isPrime = { N ->
    if (N== 1)  return false;
    if (N== 2)  return true;
    if (N== 3)  return true;
    if (N== 4)  return false;
    if (N== 5)  return true;
    if(N%2 == 0) return false;
    if(N%3 == 0) return false;

    //all primes >3 can be written in the form 6k +/- 1

    for(int i=5; i<=Math.ceil(Math.sqrt(N)); i=i+6){
        if(N % i==0) return false;
        if(N % (i+2)==0) return false;
    }

    //for(int i=5; i<=N/2; i=i+2){
    //  if(N%i==0)return false;
    //}
    return true;
}


def is_prime (x) {
    if ((x <= 1) || (x % 2 == 0)) {
        return false
    } else if ((x == 2) || (x == 3)) {
        return true
    } else {
        c = 3
        root = Math.sqrt (x)
        while (c <= root) {
            if (x % c == 0)
                return false
            c += 2
        }
        return true
    }
}