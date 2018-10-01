package token;

import trader.Trader;

public class RToken implements ERC20Token {

	private String name;
	private String symbol;
	private int totalSupply;
	
	public RToken(int supply) {
		this.name = "RToken";
		this.symbol = "RTK";
		this.totalSupply = supply;
	}
	
	@Override
	public int totalSupply() {
		return totalSupply;
	}

	@Override
	public int balanceOf(Trader owner) {
		if (owner != null) {
			return owner.getBalance();
		}
		return 0;
	}

	@Override
	public boolean transfer(Trader toTrader, int value) {
		//Assumption is that value corresponds to number of tokens. RToken has only 1 unit
		for (int i = 0; i < value; i++) {
			toTrader.addRToken(new RToken(1000));
		}
		return true;
	}

	@Override
	public boolean transferFrom(Trader fromTrader, Trader toTrader, int value) {
		//Assumption is that value corresponds to number of tokens. RToken has only 1 unit
		if (approve(fromTrader, value)) {
			fromTrader.addTransferEvent("Transferred " + value + " RTokens to " + toTrader.getId());
			toTrader.addReceivedEvent("Received " + value + " RTokens from " + fromTrader.getId());
			for (int i = 0; i < value; i++) {
				RToken token = fromTrader.removeToken();
				toTrader.addRToken(token);
			}
		}
		return false;
	}
	

	@Override
	public boolean approve(Trader spender, int value) {
		if(spender.getBalance() >= value) {
			return true;
		}
		return false;
	}

	@Override
	public int allowance(Trader owner, Trader spender) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getTotalSupply() {
		return totalSupply;
	}

	public void setTotalSupply(int totalSupply) {
		this.totalSupply = totalSupply;
	}

}
