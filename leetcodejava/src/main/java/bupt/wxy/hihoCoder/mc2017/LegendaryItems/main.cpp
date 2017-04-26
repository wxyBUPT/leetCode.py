#include <iostream>
#include <cmath>

using namespace std;

class Solution {
public:
	double getItems(int P, double Q, int N, int base) {
		if (N == 0) return 0;
		double curr = base < 7 ? P / (int)pow(2, base) * 0.01 : 0;
		double prev = 1.0, i = 1.0, result = 0;
		while (curr < 1.0) {
			result += prev * curr * i;
			prev *= 1 - curr;
			curr += Q;
			i++;
		}
		curr = 1.0;
		result += prev * curr * i;
		return result + getItems(P, Q, N - 1, base + 1);
	}
};

int main() {
	Solution* s = new Solution();
	double P, Q, N;
	cin >> P >> Q >> N;
	double result = s->getItems(P, Q / 100.0, N, 0);
	long long temp = (long long)(result * 100);
	// 保留两位有效数字
	if (result * 100 - temp >= 0.5) {
		cout << (temp + 1) * 0.01 << endl;
	} else {
		cout << temp * 0.01 << endl;
	}
	system("pause");
	return 0;
}