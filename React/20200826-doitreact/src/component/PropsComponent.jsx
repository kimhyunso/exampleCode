import React from 'react';
import PropTypes from 'prop-types';

class PropComponent extends React.Component{
    render(){
        return(
            <div className='message-container'>
                {this.props.name}
            </div>
        );
    }

}


PropComponent.propTypes = {
    name : PropTypes.string,
};

export default PropComponent;