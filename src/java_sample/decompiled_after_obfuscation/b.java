/*
 * Decompiled with CFR 0_122.
 */
public class b implements d {
	private c a;

	@Override
	public boolean a(int n, int n2) {
		if (n >= this.a() + 1) {
			throw new IndexOutOfBoundsException();
		}
		c c2 = new c(n2);
		if (this.a == null) {
			this.a = c2;
			return true;
		}
		c c3 = this.c(n - 1);
		c2.b = c3.b;
		c3.b = c2;
		return true;
	}

	@Override
	public boolean a(int n) {
		c c2 = null;
		try {
			c2 = this.c(n - 1);
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			if (n == 0) {
				this.a = null;
				return true;
			}
			return false;
		}
		c c3 = c2.b;
		c2.b = c3.b;
		return true;
	}

	@Override
	public int b(int n) {
		return this.c((int) n).a;
	}

	private c c(int n) {
		if (n == 0 || this.a == null) {
			if (this.a == null) {
				throw new IndexOutOfBoundsException("Sorry no such element: " + n);
			}
			return this.a;
		}
		c c2 = this.a;
		for (int i = 0; c2.b != null && i < n; ++i) {
			c2 = c2.b;
		}
		if (c2 == null) {
			throw new IndexOutOfBoundsException("Sorry no such element: " + n);
		}
		return c2;
	}

	public int a() {
		if (this.a == null) {
			return 0;
		}
		int n = 1;
		c c2 = this.a;
		while (c2.b != null) {
			++n;
			c2 = c2.b;
		}
		return n;
	}
}
