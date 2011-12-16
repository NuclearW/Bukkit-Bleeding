//    Copyright (C) 2011  Ryan Michela
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

package org.bukkit.plugin;

import java.util.ResourceBundle;
import java.util.logging.*;

/**
 */
public class PluginLogger extends Logger {

    private String pluginName;
    private Logger base;

    public PluginLogger(Plugin context) {
        super(null, null);
        pluginName = "[" + context.getDescription().getName() + "] ";
        base = context.getServer().getLogger();
    }

    @Override
    public void addHandler(Handler handler) throws SecurityException {
        base.addHandler(handler);     
    }

    @Override
    public void config(String s) {
        base.config(s);     
    }

    @Override
    public void entering(String className, String methodName) {
        entering(className, methodName, new Object[0]);
    }

    @Override
    public void entering(String className, String methodName, Object parameter) {
        Object[] parameters = {parameter};
        entering(className, methodName, parameters);
    }

    @Override
    public void entering(String className, String methodName, Object... parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("ENTRY  ").append(className).append(".").append(methodName).append("(");
        for (int i = 0; i < parameters.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(parameters[i]);
        }
        sb.append(")");
        finer(sb.toString());
    }

    @Override
    public void exiting(String className, String methodName) {
        finer(String.format("RETURN %s.%s()", className, methodName));
    }

    @Override
    public void exiting(String className, String methodName, Object result) {
        finer(String.format("RETURN %s.%s() => %s", className, methodName, result));
    }

    @Override
    public void fine(String s) {
        base.fine(pluginName + s);
    }

    @Override
    public void finer(String s) {
        base.finer(pluginName + s);
    }

    @Override
    public void finest(String s) {
        base.finest(pluginName + s);
    }

    @Override
    public Filter getFilter() {
        return base.getFilter();     
    }

    @Override
    public Handler[] getHandlers() {
        return base.getHandlers();     
    }

    @Override
    public Level getLevel() {
        return base.getLevel();     
    }

    @Override
    public String getName() {
        return base.getName();     
    }

    @Override
    public Logger getParent() {
        return base.getParent();     
    }

    @Override
    public ResourceBundle getResourceBundle() {
        return base.getResourceBundle();     
    }

    @Override
    public String getResourceBundleName() {
        return base.getResourceBundleName();     
    }

    @Override
    public boolean getUseParentHandlers() {
        return base.getUseParentHandlers();     
    }

    @Override
    public void info(String s) {
        base.info(pluginName + s);     
    }

    @Override
    public boolean isLoggable(Level level) {
        return base.isLoggable(level);     
    }

    @Override
    public void log(Level level, String s) {
        base.log(level, pluginName + s);     
    }

    @Override
    public void log(Level level, String s, Object o) {
        base.log(level, pluginName + s, o);     
    }

    @Override
    public void log(Level level, String s, Object[] objects) {
        base.log(level, pluginName + s, objects);     
    }

    @Override
    public void log(Level level, String s, Throwable throwable) {
        base.log(level, pluginName + s, throwable);     
    }

    @Override
    public void log(LogRecord logRecord) {
        base.log(logRecord);     
    }

    @Override
    public void logp(Level level, String s, String s1, String s2) {
        base.logp(level, s, s1, pluginName + s2);     
    }

    @Override
    public void logp(Level level, String s, String s1, String s2, Object o) {
        base.logp(level, s, s1, pluginName + s2, o);     
    }

    @Override
    public void logp(Level level, String s, String s1, String s2, Object[] objects) {
        base.logp(level, s, s1, pluginName + s2, objects);     
    }

    @Override
    public void logp(Level level, String s, String s1, String s2, Throwable throwable) {
        base.logp(level, s, s1, pluginName + s2, throwable);     
    }

    @Override
    public void logrb(Level level, String s, String s1, String s2, String s3) {
        base.logrb(level, s, s1, s2, pluginName + s3);     
    }

    @Override
    public void logrb(Level level, String s, String s1, String s2, String s3, Object o) {
        base.logrb(level, s, s1, s2, pluginName + s3, o);     
    }

    @Override
    public void logrb(Level level, String s, String s1, String s2, String s3, Object[] objects) {
        base.logrb(level, s, s1, s2, pluginName + s3, objects);     
    }

    @Override
    public void logrb(Level level, String s, String s1, String s2, String s3, Throwable throwable) {
        base.logrb(level, s, s1, s2, pluginName + s3, throwable);     
    }

    @Override
    public void removeHandler(Handler handler) throws SecurityException {
        base.removeHandler(handler);     
    }

    @Override
    public void setFilter(Filter filter) throws SecurityException {
        base.setFilter(filter);     
    }

    @Override
    public void setLevel(Level level) throws SecurityException {
        base.setLevel(level);     
    }

    @Override
    public void setParent(Logger logger) {
        base.setParent(logger);     
    }

    @Override
    public void setUseParentHandlers(boolean b) {
        base.setUseParentHandlers(b);     
    }

    @Override
    public void severe(String s) {
        base.severe(pluginName + s);     
    }

    @Override
    public void throwing(String className, String method, Throwable throwable) {
        finer(String.format("THROW  %s.%s()\n%s\n", className, method, throwable));
    }

    @Override
    public void warning(String s) {
        base.warning(pluginName + s);     
    }
}
