package com.skriptdev.skbase.skript.expressions;


import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;


/**
 * Allows Skript scripts to see the current version of SKbase
 *
 * <p>Example:</p>
 * <pre>
 *     set {_version} to SKbase version
 * </pre>
 */
public class SKbaseVersionExpression extends SimpleExpression<String> {



    @Override
    public boolean init(
            Expression<?>[] expressions,
            int matchedPattern,
            Kleenean isDelayed,
            SkriptParser.ParseResult parseResult
    ) {
        return true;
    }


    @Override
    protected String[] get(Event event) {
        return new String[]{"0.1.0"};
    }



    @Override
    public boolean isSingle() {
        return true;
    }


    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }


    @Override
    public String toString(Event event, boolean debug) {
        return "SKbase version";
    }



}


