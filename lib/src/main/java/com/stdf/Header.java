/**
 * Copyright 2009-2012 tragicphantom
 *
 * This file is part of stdf4j.
 *
 * Stdf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Stdf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with stdf4j.  If not, see <http://www.gnu.org/licenses/>.
**/
package com.stdf;

public class Header{
   private int        length;
   private RecordType type;

   public Header(){
      length = 0;
      type   = new RecordType(0, 0);
   }

   public Header(int length, int type, int subType){
      this.length = length;
      this.type   = new RecordType(type, subType);
   }

   public void set(int length, int type, int subType){
      this.length = length;
      this.type.set(type, subType);
   }

   public int getLength(){
      return length;
   }

   public int getType(){
      return type.getType();
   }

   public int getSubType(){
      return type.getSubType();
   }

   public RecordType getRecordType(){
      return type;
   }
}
