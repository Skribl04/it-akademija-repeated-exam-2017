
var HelloWorldComponent = React.createClass({
	
	class app {
		
		constructor(props) {
			super(props);
			this.state = {flights: []};
		}

		componentDidMount() {
			client({method: 'GET', path: '/api/flights'}).done(response => {
				this.setState({flights: response.entity._embedded.employees});
			});
		}

		render() {
			return (
				<Flightlist flights={this.state.flights}/>
			)
		}
		
	}
	
	class Flightlist {
		rendr(){
			var flights = this.props.flights.map(flight =>
			<Flight key={flight._links.self.href} flight={flight}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>DATE</th>
						<th>TIME</th>
						<th>FlightNumber</th>
						<th>Company</th>
						<th>Status</th>
					</tr>
					{flights}
				</tbody>
			</table>
		)
	
	}
	
	class flight{
	render() {
		return (
			<tr>
				<td>{this.props.flight.ID}</td>
				<td>{this.props.flight.DATE}</td>
				<td>{this.props.flight.TIME}</td>
				<td>{this.props.flight.FlightNumber}</td>
				<td>{this.props.flight.Company}</td>
				<td>{this.props.flight.Status}</td>
			</tr>
		)
	}
}
	
		}
	}
  render: function() {
    return (
      <div><Flightlist /></div>
    );
  }
});

window.HelloWorldComponent = HelloWorldComponent;
