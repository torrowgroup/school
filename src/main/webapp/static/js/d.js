 
		'use strict';

		$(function () {
		    'use strict';

		    $('#singleDateRange').DatePicker({
		        startDate: moment()
		    });

		    $('#rangedate').DatePicker({
		        type: 'rangedate',
		    startDate: moment().subtract(1, 'week'),
		    endDate: moment(),
		    ranges: [{
		        label: "昨天",
		        startDate: moment().subtract(1, 'day'),
		        endDate: moment().subtract(1, 'day')
		    }, {
		        label: '星期天',
		        startDate: moment().startOf('week'),
		        endDate: moment()
		    }, {
		        label: '2个星期',
		        startDate: moment().startOf('week').subtract(1, 'week'),
		        endDate: moment()
		    }, {
		        label: '这个月',
		        startDate: moment().startOf('month'),
		        endDate: moment()
		    }, {
		        label: '下个月',
		        startDate: moment().startOf('month').subtract(1, 'month'),
		        endDate: moment().startOf('month')
		    }, {
		        label: '今年',
		        startDate: moment().startOf('year'),
		        endDate: moment().startOf('moth')
		    }]
		    });
		});
	 