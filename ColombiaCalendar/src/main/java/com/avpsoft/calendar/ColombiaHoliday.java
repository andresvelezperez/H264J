/*
 * Copyright (C) 2015 andres
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.avpsoft.calendar;

import static com.avpsoft.calendar.Util.createDefaultCalendar;
import java.util.Calendar;

/**
 *
 * @author andres
 */
public class ColombiaHoliday implements Holiday {
    
    private Calendar day;
    private String holidayName;
    
    protected ColombiaHoliday(){
        //
    }
    
    public ColombiaHoliday(final String name,int year,int month, int day,boolean emilini){
        
        this.holidayName = name;
        
        if(!emilini){
            this.day = createDefaultCalendar(year, month, day);
        }else if(emilini){
            this.day = this.leyEmiliani(year, month, day);
        }
    }
    
    public ColombiaHoliday(final String name,Calendar easterday, int addEaster,boolean emilini){
        
        this.holidayName = name;
        
        if(!emilini){
            day = easterAdd(easterday, addEaster);
        }else if(emilini){
            day = easterWithLeyEmiliani(easterday, addEaster);
        }
        
    }
    
    @Override
    public Calendar getHoliday(){
        return day;
    }

    @Override
    public String getHolidayName() {
        return holidayName;
    }
    
    private Calendar easterAdd(Calendar easterDay, int days) {
        Calendar calendar = (Calendar) easterDay.clone();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar;
    }
    
    /**
     * Ley Memiliani o Ley 51 de 1983
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    private Calendar leyEmiliani(int year, int month, int day) {

        Calendar calendar = createDefaultCalendar(year, month, day);
        leyEmiliani(calendar);
        return calendar;
    }
    
    private Calendar easterWithLeyEmiliani(Calendar computus, int days){
        Calendar calendar = (Calendar) computus.clone();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        leyEmiliani(calendar);
        return calendar;
    }

    private void leyEmiliani(final Calendar calendar) {
        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
        if (diaSemana != Calendar.MONDAY) {
            int dias = (Calendar.SATURDAY - diaSemana + 2) % 7;
            calendar.add(Calendar.DAY_OF_YEAR, dias);
        }
    }
    
    
    
}
