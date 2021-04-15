package xyz.anarres.leetcode.dailychallenge;

import java.util.Iterator;
import java.util.List;

/**
You are given a nested list of integers nestedList. Each element is either an integer
 or a list whose elements may also be integers or other lists. Implement an iterator
 to flatten it.

Implement the NestedIterator class:

    NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
    int next() Returns the next integer in the nested list.
    boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 */
public class NestedIterator implements Iterator<Integer> {
	private int nextNested;
	private int nextInt;
	private List<NestedInteger> nestedList;

	public NestedIterator(List<NestedInteger> nestedList) {
		this.nestedList = nestedList;
		nextNested = (nestedList.size() == 0) ? -1 : 0;
		nextInt = 0;
	}

	@Override
	public boolean hasNext() {
		// we advance pointers before returning a value, so they're -1 when we can't
		return nextNested >= 0;
	}

	@Override
	public Integer next() {
		if (nextNested < 0) {
			// nothing, or nothing we know of
			return null;
		}

		NestedInteger next = nestedList.get(nextNested);
		if (next.isInteger()) {
			// advance pointers, and we'll return this
			nextInt = 0;
			nextNested++;
			if (nextNested >= nestedList.size())
				nextNested = -1;
			return next.getInteger();
		}

		// it's a list
		// advance pointers, and return the first
		List<NestedInteger> nextList = next.getList();
		Integer nextVal = nextList.get(nextInt).getInteger();
		nextInt++;
		if (nextInt >= nextList.size()) {
			nextInt = 0;
			nextNested++;
			if (nextNested >= nestedList.size())
				nextNested = -1;
		}
		return nextVal;
	}
}

interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return empty list if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
