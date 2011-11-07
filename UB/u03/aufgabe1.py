class Parser(object):
    def __init__(self, input):
        self.input = input
        self.lookahead_idx = 0
        self.S()
    
    def lookahead(self):
        return self.input[self.lookahead_idx]

    def match(self, terminal):
        if terminal == self.lookahead():
            self.lookahead_idx += 1
            if self.lookahead_idx >= len(self.input):
                # make lookahead stop at the end of input
                self.lookahead_idx = len(self.input)-1
        else:
            raise SyntaxError(
                    "syntax error '%s', expected '%s'" %
                        (self.lookahead(), terminal)
                )
    
# I don't allways Yoda-compare, but when I do it serves clearness.
class ParserA(Parser):
    def S(self):
        if   '+' == self.lookahead():
            self.match('+')
            self.S()
            self.S()
        elif '-' == self.lookahead():
            self.match('-')
            self.S()
            self.S()
        elif 'a' == self.lookahead():
            self.match('a')
        else:
            raise SyntaxError(
                    "syntax error: no rule for '%s'" %
                        self.lookahead()
                )

class ParserB(Parser):
    def S(self):
        if   '(' == self.lookahead():
            self.match('(')
            self.S()
            self.match(')')
            self.S()

class ParserC(Parser):
    def E(self):
        if   '0' == self.lookahead():
            self.match('0')
            self.E()
            self.match('1')
        elif '1' == self.lookahead():
            self.match('1')
        else:
            raise SyntaxError(
                    "syntax error: no rule for '%s'" %
                        self.lookahead()
                )

    def S(self):
        if   '0' == self.lookahead():
            self.match('0')
            self.E()
        else:
            raise SyntaxError(
                    "syntax error: no rule for '%s'" %
                        self.lookahead()
                )