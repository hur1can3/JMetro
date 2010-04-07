/**
 * 
 */
package edu.gvsu.jmetro.engine;

/**
 * @author Matthew Levandowski (levandma@mail.gvsu.edu)
 * @version Apr 6, 2010
 */
public enum Direction {
	N {

		public Direction getOpposite() {
			return S;
		}
	},
	E {

		public Direction getOpposite() {
			return W;
		}
	},
	S {

		public Direction getOpposite() {
			return N;
		}
	},
	W {

		public Direction getOpposite() {
			return E;
		}
	};

	public abstract Direction getOpposite();
}
