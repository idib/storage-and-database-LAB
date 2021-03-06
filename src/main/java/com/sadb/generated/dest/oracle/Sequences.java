/*
 * This file is generated by jOOQ.
 */
package com.sadb.generated.dest.oracle;


import java.math.BigInteger;

import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in SANDDB
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>SANDDB.BLOCK_SEQ</code>
     */
    public static final Sequence<BigInteger> BLOCK_SEQ = new SequenceImpl<BigInteger>("BLOCK_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.CONFERENCE_SEQ</code>
     */
    public static final Sequence<BigInteger> CONFERENCE_SEQ = new SequenceImpl<BigInteger>("CONFERENCE_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.DORMITORY_SEQ</code>
     */
    public static final Sequence<BigInteger> DORMITORY_SEQ = new SequenceImpl<BigInteger>("DORMITORY_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.EVENTS_SEQ</code>
     */
    public static final Sequence<BigInteger> EVENTS_SEQ = new SequenceImpl<BigInteger>("EVENTS_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.EVENT_TYPE_SEQ</code>
     */
    public static final Sequence<BigInteger> EVENT_TYPE_SEQ = new SequenceImpl<BigInteger>("EVENT_TYPE_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.FORM_EDUCATION_SEQ</code>
     */
    public static final Sequence<BigInteger> FORM_EDUCATION_SEQ = new SequenceImpl<BigInteger>("FORM_EDUCATION_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.PUBLICATIONS_SEQ</code>
     */
    public static final Sequence<BigInteger> PUBLICATIONS_SEQ = new SequenceImpl<BigInteger>("PUBLICATIONS_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.READER_SHEET_SEQ</code>
     */
    public static final Sequence<BigInteger> READER_SHEET_SEQ = new SequenceImpl<BigInteger>("READER_SHEET_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.ROOM_SEQ</code>
     */
    public static final Sequence<BigInteger> ROOM_SEQ = new SequenceImpl<BigInteger>("ROOM_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.SCIENTIFIC_PROJECT_SEQ</code>
     */
    public static final Sequence<BigInteger> SCIENTIFIC_PROJECT_SEQ = new SequenceImpl<BigInteger>("SCIENTIFIC_PROJECT_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.TYPE_EDITION_SEQ</code>
     */
    public static final Sequence<BigInteger> TYPE_EDITION_SEQ = new SequenceImpl<BigInteger>("TYPE_EDITION_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.TYPE_POSITION_SEQ</code>
     */
    public static final Sequence<BigInteger> TYPE_POSITION_SEQ = new SequenceImpl<BigInteger>("TYPE_POSITION_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));

    /**
     * The sequence <code>SANDDB.TYPE_PUBLICATION_SEQ</code>
     */
    public static final Sequence<BigInteger> TYPE_PUBLICATION_SEQ = new SequenceImpl<BigInteger>("TYPE_PUBLICATION_SEQ", Sanddb.SANDDB, org.jooq.impl.SQLDataType.DECIMAL_INTEGER.precision(38).nullable(false));
}
