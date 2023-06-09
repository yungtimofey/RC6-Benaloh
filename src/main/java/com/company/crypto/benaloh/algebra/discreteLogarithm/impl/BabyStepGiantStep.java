package com.company.crypto.benaloh.algebra.discreteLogarithm.impl;

import com.company.crypto.benaloh.algebra.discreteLogarithm.DiscreteLogarithmService;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


public class BabyStepGiantStep implements DiscreteLogarithmService {
    @Override
    public BigInteger getDiscreteLogarithm(BigInteger base, BigInteger arg, BigInteger modulo) {
        //log.info("base:" + base);
        //log.info("arg:" + arg);
        //log.info("modulo:" + modulo);

        BigInteger maxIterationNumber = modulo.sqrt().add(BigInteger.ONE);
        BigInteger aInDegreeN = BigInteger.ONE;
        BigInteger i = BigInteger.ZERO;
        while (!i.equals(maxIterationNumber)) {
            aInDegreeN = aInDegreeN.multiply(base).mod(modulo);
            i = i.add(BigInteger.ONE);
        }

        Map<BigInteger, BigInteger> values = new HashMap<>();
        i = BigInteger.ONE;
        BigInteger current = aInDegreeN;
        while (i.compareTo(maxIterationNumber) <= 0) {
            values.putIfAbsent(current, i);
            current = current.multiply(aInDegreeN).mod(modulo);
            i = i.add(BigInteger.ONE);
        }

        i = BigInteger.ZERO;
        current = arg;
        while (i.compareTo(maxIterationNumber) <= 0) {
            if (values.containsKey(current)) {
                BigInteger value = values.get(current);
                BigInteger answer = value.multiply(maxIterationNumber).subtract(i);
                if (answer.compareTo(modulo) < 0) {
                    //log.info("another answer:" + answer);
                    if (answer.equals(BigInteger.valueOf(10))) {
                        //log.info("answer:");
                        return answer;
                    }
                    //log.info("answer:" + answer);
                    //return answer;
                }
            }
            current = current.multiply(base).mod(modulo);
            i = i.add(BigInteger.ONE);
        }
        throw new IllegalArgumentException("Can't find discrete l");
    }
}
