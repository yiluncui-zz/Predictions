namespace java com.foobar.predictions

include "types.thrift"

service PredictionsActivity {
    double predict(1:types.Candidate candidate);
}