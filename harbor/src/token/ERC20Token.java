package token;

import trader.Trader;

public interface ERC20Token extends Token {
	public int totalSupply();
	public int balanceOf(Trader owner);
	public boolean transfer(Trader toTrader, int value);
	public boolean transferFrom(Trader fromTrader, Trader toTrader, int value);
	public boolean approve(Trader spender, int value);
	public int allowance(Trader owner, Trader spender);
}
