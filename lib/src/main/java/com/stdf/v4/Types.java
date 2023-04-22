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
package com.stdf.v4;

import com.stdf.RecordDescriptor;
import com.stdf.RecordType;
import com.stdf.RecordTypeParser;

import java.util.HashMap;
import java.util.Map;

public final class Types{
   private static HashMap<RecordType, RecordDescriptor> records =
      RecordTypeParser.parse("stdf_v4_types.xml");

   public static Map<RecordType, RecordDescriptor> getRecordDescriptors(){
      return records;
   }
}
