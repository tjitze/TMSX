package emu.memory;

public class RAMSlot extends AbstractSlot {

	private int size = 0xFFFF + 1;
	
	public final byte[] mem;
	
	public RAMSlot() {
		mem = new byte[size];
		for (int i = 0; i < size; i++) mem[i] = (byte)0xff;
	}
	
	public RAMSlot(int s) {
		this.size = s;
		mem = new byte[size];
		for (int i = 0; i < size; i++) mem[i] = (byte)0xff;
	}
	
	public byte rdByte(short addr) {
		return mem[addr & 0xffff];
	}
	
	public final void wrtByte(short addr, byte value) {
		mem[addr & 0xffff] = value;
	}

	@Override
	public boolean isWritable(short addr) {
		return true;
	}
	
	public int getSize() {
		return size;
	}
}
