/*
 * Copyright (c) 2009-2010, Sergey Karakovskiy and Julian Togelius
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the Mario AI nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package supermario.ch.idsia.evolution;


/**
 * Interface to a generic <code>Evolvable</code>, one of the objects needed by an
 * EA to run.<br>
 *
 * @see EA
 */
public interface Evolvable
{

/**
 * Produces a new instance of the same <code>Evolvable</code>, all the parameters
 * (e.g. mutation rate, limits etc.) must be copied to the new object.
 * <p/>
 * The <code>EA</code> will produce the initial population adding to this first
 * <code>Evolvable</code> as many others as needed, generated by this method.<br>
 * Any random initialization should therefore be placed here.
 *
 * @return the <code>new Evolvable</code>.
 */
public Evolvable getNewInstance();

/**
 * Returns a deep copy (i.e. as deep as possible) of the <code>Evolvable</code>.
 *
 * @return the copy.
 */
public Evolvable copy();

/**
 * Resets the <code>Evolvable</code> to its default state (e.g. reset a recurrent network).
 */
public void reset();

/**
 * Applies the predefined mutation to the <code>Evolvable</code>.
 */
public void mutate();

/**
 * Produces a suitable <code>String</code> representation of the <code>Evolvable</code>.
 *
 * @return the info.
 */
public String toString();
}