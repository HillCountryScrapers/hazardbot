package com.corelogic.hazardbot.notifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoadClosure {

    private String location;
    private String crossStreets;
}

//        ":@computed_region_8spj_utxs": "5",
//        ":@computed_region_a3it_2a2z": "2859",
//        "business_or_dept_closing_road": "Other",
//        "close_date": "2017-03-02T13:54:27.000",
//        "council_district": "5",
//        "county": "TRAVIS",
//        "created_date": "2017-03-02T13:54:27.000",
//        "cross_streets": "SOUTHRIDGE AND MORGAN LANE",
//        "date_and_time_of_reopening": "3/17/2017 @ 10:OO AM",
//        "detour_information": "TRAFFIC CONTROL HAS BEEN ADDED WITH A DETOUR SIGN",
//        "lanes_closed": "Full Road",
//        "last_update_date": "2017-03-02T13:54:27.000",
//        "latitude_coordinate": "30.23222667",
//        "latitude_longitude": {
//        "type": "Point",
//        "coordinates": [
//        -97.781247,
//        30.232227
//        ]
//        },
//        "longitude_coordinate": "-97.78124701",
//        "map_page": "614X",
//        "map_tile": "MG19",
//        "method_received": "Phone",
//        "name_of_business": "COYOTE CONSTRUCTION SERVICES",
//        "owning_department": "Transportation",
//        "permit_number": "2016-145221-EX",
//        "routine_or_emergency": "Routine",
//        "service_request_sr_number": "17-00053149",
//        "sr_description": "Lane/Road Closure Notification",
//        "sr_location": "3903 CLAWSON RD, AUSTIN, TX 78704",
//        "sr_status": "Closed",
//        "sr_type_code": "EMROCLRE",
//        "state_plane_x_coordinate": "3102480.00204104",
//        "state_plane_y_coordinate": "10057442.0015624",
//        "status_change_date": "2017-03-02T13:54:27.000",
//        "street_number": "3903",
//        "zip_code": "78704"
//        }
